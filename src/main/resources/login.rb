require 'watir'
require 'phantomjs'
require 'browser'


#phantom js browser opening from user interface
#start local phantom js driver from local at port 8001 with commadn > 1.1\bin>phantomjs --webdriver=8001
Selenum::WebDriver.for :remote, url: 'http://192.168.0.106:8001'

browser = Watir::Browser.new :phantomjs
# magneto url to open 
url=ARGV[0]
firstname=ARGV[1]
lastname=ARGV[2]
password=ARGV[3]
confirmpassword=ARGV[4]
email=ARGV[5]
if ARGV.length = 6
	middlename=ARGV[5]
end

browser.goto(ur)
form =browser.form(:id=> 'form-validate')
form.text_field(id: 'firstname').set firstname
form.text_field(id: 'lastname').set lastname
if ARGV.length = 6
	form.text_field(id: 'middlename').set middlename
end
form.text_field(id: 'email_address').set email_address
form.text_field(id: 'password').set password
form.text_field(id: 'confirmation').set confirmpassword
browser.form(:id=> 'form-validate').submit

browser.goto(url);
