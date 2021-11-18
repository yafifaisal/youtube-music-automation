# Youtube Music Automation Test

Youtube Music Automation Test is a simple project of automation framewrok using Maven as development tools and built with Selenium driver with Java language.

## Getting Started

The Framework is designed to cover common test cases for Youtube Music. 
Because it need a credential account to login to music.youtube.com , the positive test case for login is unavailable, it only cover for negative test case of login. 
The remaining test case are `SearchSong` test case and `PlayMusic` test case. 

Browser is limited to only Chrome version >= 95 and Firefox any version. 

### Dependencies

- JDK version 16
- Chrome version >= 95

### Executing Test

From Terminal
- Unzip project
- Open Terminal and navigate to project directory
- Run with command `mvn test` 

From Eclipse
- Open project from eclipse
- Run test by TestNG compiler
