Written in Java

Entry Point in `src/main/java/Main`

Test Entry Point in `src/test/java/services/SchedulingTest`

## Notes

- I haven't tested it against your backend. I haven't even called your backend at all with the API key I think, though I've run the program locally as part of development. I still built the service class with the functions you need to use your backend (i.e., start, stop)

- I used swagger-codegen-cli to generate the java classes from your swagger definitions, in `io.swagger.client`. I'm familiar with this tool, so I figured it was faster than manually creating all the models, HTTP request code, and JSON hookups in Java.

- I added a test case with Mockito against the critical function (`Scheduling.scheduleAppointments()`)

- I iterated on several solutions and settled on using a multi-key hash table to store the existing schedule to do quick lookups to see if an appointment already exists. Before that I had used just single-key hash tables `{Doctor, List<appointments>}`, but then I ended up needing to filter that list so often to get data I needed (somewhat of a pain in java)

- I tried to use best practices in a lot of places (layered architecture, business logic goes within service class, storage of API key in env. variables, validation checks, helper functions to allow tests to mock dependencies, etc)

## Unfinished

- Only 1 part of the main algorithm is unfinished, and that was checking the doctors schedule to see if the person had a previous appointment within 1 week. That is a fairly trivial check but I'm at the three hour mark so I'll leave it incomplete.

- I've also written a TODO for the test case to verify the actual call does what it says it should do rather than just printing out the invocations with the mock. Related to that is the fixtures could use some love rather than just having generic name "A".
