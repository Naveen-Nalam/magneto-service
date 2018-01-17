# spring program to submit a magneto form

Magneto form is html form. To submit this form we need to load the form.
I have used phanthom js headless browser to open and submit. This spring boot app has a single controller and CreateUserController.java
and have a rest endpoint to accepts a json request and pass to service impl.

In service imple, we open a command liner of ruby script login.rb which is in resource and pass all required parameters from java request
to this ruby script as command line arguments. ruby script file is externalized and path is given in application.properties.


#Steps to install
# assume we have installed maven https://maven.apache.org/download.cgi and set all required parameters like JDK etc in environment variables

# start phanthon js server at a port C:\Personal\softwares\phantomjs-2.1.1\bin>phantomjs --webdriver=8001 and login.rb to should lister to this port to open a headless browser
