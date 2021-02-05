# Full Stack Chat

This project demonstrates how you can create a client and a server for a chat.

## Running the server

To run the server, use the green triangle near the `main` function in the `server/` module.

## Running the client

The following command will build the web client as a set of files into the `client/build/distributions` dir:

```shell
./gradlew :client:browserDevelopmentWebpack
```

To chat, open `index.html` file via a browser. You can duplicate tabs to simulate different clients.

Don't forget to specify which server to use via query param. By default, it will be `index.html?ws=localhost:8885`.

## License

The source code of this project is available under Apache 2.0 license.
