Forum
=====

Web-application project

Forum made with jsf/java beans



Create admin by adding a user with rank above 0 manually into the db.

Creating user with name/email thats already in db, causes nullpointer beacuse no validation.
Removing SubTopics removes them from database but not from view for some reason, requires rerun of forum to show.
