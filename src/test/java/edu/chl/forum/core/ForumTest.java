package edu.chl.forum.core;

import edu.chl.forum.auth.ForumUser;
import edu.chl.forum.core.Forum;
import java.util.Date;
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
import static org.junit.Assert.assertTrue;
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
                .addPackage("edu.chl.forum.auth")
                // This will add test-persitence.xml as persistence.xml (renamed)
                // in folder META-INF, see Files > jpa_managing > target > arquillian
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                // Must have for CDI to work
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");


    }
          
    @Before  // Run before each test
    public void before() throws Exception {
        //clearAll();
    }
    
  
    /*
    @Test
    public void testPersistAProduct() throws Exception {
        forum.getUserCatalogue().create(new ForumUser("Test"));
        List<ForumUser> ul = forum.getUserCatalogue().findAll();
        assertTrue(ul.size() > 0);
        }
        
        assertTrue(true);}
       
        Product p = new Product("aaa", 999);
        shop.getProductCatalogue().create(p);
        List<Product> ps = shop.getProductCatalogue().findAll();
        assertTrue(ps.size() > 0);
        assertTrue(ps.get(0).getName().equals(p.getName()));
    }
    
    @Test
    public void testProductGetByName() throws Exception {
        Product p = new Product("aaa", 999);
        shop.getProductCatalogue().create(p);
        List<Product> ps = shop.getProductCatalogue().getByName("aaa");
        assertTrue(ps.size() > 0);
        assertTrue(ps.get(0).getName().equals(p.getName()));
    }
    
    @Test
    public void testDelete() throws Exception {
        Product p = new Product("aaa", 999);
        shop.getProductCatalogue().create(p);
        shop.getProductCatalogue().delete(p.getId());
        List<Product> ps = shop.getProductCatalogue().getByName("aaa");
        assertTrue(ps.isEmpty());
    }
    
    @Test
    public void testUpdate() throws Exception {
        Product p = new Product("aaa", 999);
        shop.getProductCatalogue().create(p);
        p = new Product(p.getId(), "bbb", 888);
        shop.getProductCatalogue().update(p);
        List<Product> ps = shop.getProductCatalogue().getByName("bbb");
        List<Product> ps2 = shop.getProductCatalogue().getByName("aaa");
        assertTrue(ps.get(0).getName().equals(p.getName()));
        assertTrue(ps2.isEmpty());
    }
    
    @Test
    public void testFindRange() throws Exception {
        String[] names = "aaa, bbb, ccc, ddd, eee, fff, ggg, hhh".split(",");
        for (String s : names) {
            Product p = new Product(s, 111);
            shop.getProductCatalogue().create(p);
        }
        List<Product> values = shop.getProductCatalogue().findRange(2, 2);
        assertTrue(values.get(0).getName().equals(names[2]));        
    }
    
    @Test
    public void testFind() throws Exception {
        Long a = Long.valueOf(5);
        Product p  = new Product(a,"aaa", 999);
        shop.getProductCatalogue().create(p);
        Product c = shop.getProductCatalogue().find(a);
        assertTrue(c.getId() == p.getId());
        
    }
    
    @Test
    public void testGetById() throws Exception {
        Long a = Long.valueOf(5);
        Product p  = new Product(a,"aaa", 999);
        shop.getProductCatalogue().create(p);
        Product c = shop.getProductCatalogue().getById(a);
        assertTrue(c.getId() == p.getId());
    }
    
    @Test
    public void testGetByPrice() throws Exception {
        Product a = new Product("a", 10);
        Product b = new Product("b", 20);
        Product c = new Product("c", 20);
        shop.getProductCatalogue().create(a);
        shop.getProductCatalogue().create(b);
        shop.getProductCatalogue().create(c);
        
        List<Product> ps = shop.getProductCatalogue().getByPrice((double) 20);
        assertTrue(ps.size() == 2); 
    }
    */
    @Test
    public void testDB() throws Exception {
      
        forum.getUserCatalogue().create(new ForumUser("test"));
        
        forum.getPostCatalogue().create(new Post(12L, "test", new ForumUser("test testsson"),new Date()));
        assertTrue(forum.getPostCatalogue().count() == 1);
        //assertTrue(forum.getPostCatalogue().count() == 1);
        
        /*
        shop.getProductCatalogue().create(new Product("apple", 20));
        shop.getProductCatalogue().create(new Product("pear", 33));
        shop.getProductCatalogue().create(new Product("pineapple", 44));
        
        utx.begin();
        em.createQuery("update Product p set p.price= 400 where p.price = 20").executeUpdate();
        utx.commit();
        
        List<Product> ps = shop.getProductCatalogue().getByPrice((double) 400);
        assertTrue(ps.size()>0);*/
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
        //em.createQuery("delete from PurchaseOrder").executeUpdate();
        //em.createQuery("delete from Customer").executeUpdate();
        //em.createQuery("delete from Product").executeUpdate();
        utx.commit();
    }   
    
}
