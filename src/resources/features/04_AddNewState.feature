Feature: Localization management
Scenario: Adds a new state
	Given ther user is on the login page of the administration panel (/administrator)
	When the user enters "admin@prestashop.com" in the "Email address" field
		And enters "password" in the "Password" field
		And clicks the "Login" button
		And hovers on "Localization"
		And clicks on "States"
		And clicks the "Add new state" button
		And enters "Liguria" in the "Name" field
		And enters "1121" in the "ISO code" field
		And selects "Italy" in the "Country" dropdown select
		And selects "Europe" in the "Zone" dropdown select
		And clicks the "Save" button
	Then "Successfull update" is shown on a green box
	
	Given the previous assertion passed
	Then the user clicks on the user icon in the top right corner of the page
	And clicks the "Sign out" link