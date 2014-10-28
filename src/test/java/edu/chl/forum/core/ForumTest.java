package edu.chl.forum.core;


import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Testing the persistence layer
 *
 * NOTE NOTE NOTE: JavaDB (Derby) must be running (not using an embedded
 * database) GlassFish not needed using embedded
 *
 * @author hajo
 */
@RunWith(Arquillian.class)
public class ForumTest {
    
    @Inject
    IForum forum;

    @Inject
    UserTransaction utx; 
    
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "forum.war")
                // Add all classes
                .addPackage("edu.chl.forum.core")
                // This will add test-persitence.xml as persistence.xml (renamed)
                // in folder META-INF, see Files > jpa_managing > target > arquillian
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                // Must have for CDI to work
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");


    }
          
    @Before  // Run before each test
    public void before() throws Exception {
        clearAll();
    }
    @After
    public void tearDown() throws Exception {
        clearAll();
    }
    
    @Test
    public void testPersist() throws Exception {
        forum.getUserCatalogue().create(new ForumUser("pelle"));
        forum.getMainTopicCatalogue().create(new MainTopic());
        forum.getThreadCatalogue().create(new ForumThread());
        forum.getSubTopicCatalogue().create(new SubTopic());
        forum.getPostCatalogue().create(new Post());

        assertTrue(forum.getPostCatalogue().count() > 0);
        assertTrue(forum.getSubTopicCatalogue().count() > 0);
        assertTrue(forum.getThreadCatalogue().count() > 0);
        assertTrue(forum.getUserCatalogue().count() > 0);
        assertTrue(forum.getMainTopicCatalogue().count() > 0);
    }
    
    @Test
    public void testCreateRelation() {
        
        MainTopic maintopic = new MainTopic("topic","desc");
        maintopic.addSubTopic(new SubTopic("hej", "desc"));
        forum.getMainTopicCatalogue().create(maintopic);
        assertTrue(forum.getMainTopicCatalogue().findAll().get(0).getList().size() > 0);
        assertTrue(forum.getSubTopicCatalogue().findAll().get(0).getTitle().equals("hej"));    
    }
    @Test
    public void testCascadeRemove() {
        MainTopic maintopic = new MainTopic("topic","desc");
        maintopic.addSubTopic(new SubTopic("hej", "desc"));
        forum.getMainTopicCatalogue().create(maintopic);
        forum.getMainTopicCatalogue().delete(maintopic.getId());
        assertTrue(forum.getSubTopicCatalogue().count()==0);
        assertTrue(forum.getMainTopicCatalogue().count()==0);
    }
    @Test
    public void testedit() {
        MainTopic maintopic = new MainTopic("topic","desc");
        SubTopic subtopic = new SubTopic("hej", "desc");
        maintopic.addSubTopic(subtopic);
        forum.getMainTopicCatalogue().create(maintopic);
        subtopic.setTitle("nej");
        forum.getSubTopicCatalogue().update(subtopic);
        assertTrue(forum.getSubTopicCatalogue().count() == 1);
        assertTrue(forum.getSubTopicCatalogue().findAll().get(0).getTitle().equals("nej"));
    }
    @Test
    public void testGetUsersPosts() {
        ForumUser user = new  ForumUser("pelle");
        Post post = new Post("post1", user);
        Post post2 = new Post("post2", user);
        Post post3 = new Post("post3", user);
        Post post4 = new Post("post4", user);
        ForumThread thread = new ForumThread("hej",post,user);
        thread.addPost(post2);
        thread.addPost(post3);
        thread.addPost(post4);
        forum.getThreadCatalogue().create(thread);
        
        assertTrue(forum.getPostCatalogue().getPostsByUserId(user.getId()).size() == 4);
    }
    
    
    // Need a standalone em to remove testdata between tests
    // No em accessible from interfaces
    @PersistenceContext
    @Produces
    @Default
    EntityManager em;

    // Order matters
    private void clearAll() throws Exception {
        utx.begin();  
        em.joinTransaction();
        em.createQuery("delete from Post").executeUpdate();
        em.createQuery("delete from ForumThread").executeUpdate();
        em.createQuery("delete from SubTopic").executeUpdate();
        em.createQuery("delete from MainTopic").executeUpdate();
        em.createQuery("delete from ForumUser").executeUpdate();
        utx.commit();
    }   
    
}
