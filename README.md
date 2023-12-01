## API endpoint:

- git clone https://github.com/metacosm/power-server
- mvn install (actually, I haven't tested this yet on Linux but this should work, otherwise skip the tests)

## Extension:

- git clone https://github.com/metacosm/quarkus-power
- git checkout use-power-server (checkout the branch where I'm trying to access the power information from the endpoint)
- mvn install -DskipTests (tests are currently failing)

### What's failing / needs to be figured out:

- Line 98: Trying to get the deserialized object directly from the request fails but reading the entity and then
  deserializing it via the ObjectMapper works (and I can live with this now)
- SSE handling currently doesn't work at all but I haven't looked too deep into it, might be my endpoint as well
- In the longer term, it might be interesting to provide a cleaner way for extensions to perform REST calls more easily.
  Might not be via the Quarkus REST client but maybe something cleaner that guides the user towards what works?


## Test application (this app)

- quarkus dev
- start the power server (it's better to start it after the test app start so that you can remote debug the extension on 5005 if you start the power server using dev mode, which I tend to do)
  - cd to wherever you cloned the power-server project
  - run the server: java -jar server/target/quarkus-app/quarkus-run.jar
- When the app is ready, press `:` in the dev mode console
- Type: `power start`