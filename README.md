# Mobile test framework

> _The page object model is the industry recommended best practice.  This model helps make test code more readable, maintainable, and reusable.  By encapsulating page logic into methods on that given page object, it prevents and minimizes code duplication as page actions are extremely easy to find and use.

## Core principles
* UI identifiers are contained in single location (page object) and changes to UI only take place in one spot
* Timing issues and page operations are encapsulated in the page object rather than scattered throughout tests
* Tests must go through page objects for UI interaction and are not allowed to interact with webdriver directly
* Locators and tests remain separate so when locators change the tests do not require any changes
* Page objects can encapsulate platform differences and site (MCOM / BCOM) differences allowing us to write cross platform tests for both MCOM and BCOM.
* The object orientated nature of the page object model makes test writing / reading much easier and we can take advantage of a compiled language to avoid runtime errors when changing methods / pages.