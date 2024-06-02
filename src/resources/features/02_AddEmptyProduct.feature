Feature: Catalog management
Scenario: Tries to add a product without name and fails
	Given ther user is on the login page of the administration panel (/administrator)
	When the user enters "admin@prestashop.com" in the "Email address" field
		And enters "password" in the "Password" field
		And clicks the "Login" button
		And hovers on "Catalog"
		And clicks on "Products"
		And clicks the "Add new product" button
		And clicks the "Save" button
	Then "2 errors This link_rewrite field is required at least in English (English) This name field is required at least in English (English)" is shown on a red box
	
	Given the previous assertion passed
	Then the user clicks on the user icon in the top right corner of the page
	And clicks the "Sign out" link