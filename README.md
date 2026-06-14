## JUnit-Mockito
Created by Nabeel Latheef (nabeellatheef14@gmail.com) as part of learning JUnit and Mockito. All the contents related to JUnit4, JUnit5 and Mockito will be available in this repository. This is created for self learning and future referance purpose.

## Redundant Mock Initialization
When using JUnit 5, prefer the class-level annotation @ExtendWith(MockitoExtension.class). You do not need to manually call MockitoAnnotations.openMocks(this) inside a @BeforeEach method if you are already using the extension, as this causes redundant processing.

## ⚙️ How to Run the Tests
# Using IntelliJ IDEA:

1. Clone the repository and open the folder.
2. Wait for Maven to sync the dependencies.
3. Right-click the src/test/java directory and select Run 'All Tests'.
4. Using Maven (Command Line):
   ```bash
     mvn clean test
   ```

## License:
License is not required as it is created purely for learning pupose, please feel free to reuse it.
