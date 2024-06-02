Feature: Catalog management
Scenario: Adds a new product attribute
	Given ther user is on the login page of the administration panel (/administrator)
	When the user enters "admin@prestashop.com" in the "Email address" field
		And enters "password" in the "Password" field
		And clicks the "Login" button
		And hovers on "Catalog"
		And clicks on "Product Attributes"
		And clicks the "Add new attribute" button
		And enters "Quantity" in the "Name" field
		And enters "Qnt" in the "Public name" field
		And clicks the "Save" button
	Then "Successful creation" is shown on a green box

	Given the previous assertion passed
	Then the user clicks on the user icon in the top right corner of the page
	And clicks the "Sign out" link