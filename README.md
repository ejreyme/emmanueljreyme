# ktor-cv

This project was created using the [Ktor Project Generator](https://start.ktor.io).

Here are some useful links to get you started:

- [Ktor Documentation](https://ktor.io/docs/home.html)
- [Ktor GitHub page](https://github.com/ktorio/ktor)
- The [Ktor Slack chat](https://app.slack.com/client/T09229ZC6/C0A974TJ9). You'll need to [request an invite](https://surveys.jetbrains.com/s3/kotlin-slack-sign-up) to join.

## Features

Here's a list of features included in this project:

| Name                                         | Description                           |
| ----------------------------------------------|--------------------------------------- |
| [HTMX](https://start.ktor.io/p/htmx)         | Includes HTMX for front-end scripting |
| [HTML DSL](https://start.ktor.io/p/html-dsl) | Generates HTML from Kotlin DSL        |
| [Routing](https://start.ktor.io/p/routing)   | Provides a structured routing DSL     |

## Structure

This project includes the following modules:

| Path             | Description                              |
| ------------------|------------------------------------------ |
| [web](web)       | Front-end Kotlin scripts for the browser |
| [server](server) | A runnable Ktor server implementation    |

## Building

To build the project, use one of the following tasks:

| Task                                           | Description                                                          |
|------------------------------------------------|----------------------------------------------------------------------|
| `./gradlew build`                              | Build everything                                                     |
| `./gradlew -t build`                           | Build everything continuously                                        |
| `./gradlew -t :web:build`                      | Build WASM scripts continuously                                      |
| `./gradlew :server:buildFatJar`                | Build an executable JAR of the server with all dependencies included |
| `./gradlew :server:buildImage`                 | Build the docker image to use with the fat JAR                       |
| `./gradlew :server:publishImageToLocalRegistry` | Publish the docker image locally                                     |

## Running

To run the project, use one of the following tasks:

| Task                                 | Description                            |
| --------------------------------------|---------------------------------------- |
| `./gradlew -t :web:wasmJsBrowserRun` | Run scripts in a browser, without Ktor |
| `./gradlew :server:run`              | Run the server                         |
| `./gradlew :server:runDocker`        | Run using the local docker image       |

If the server starts successfully, you'll see the following output:

## Build and Deploy to Local Docker

`./gradlew :server:cleanBuildPublish`

```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```

Build docker image
`docker build -t ktor-cv-image . `

Run docker
`docker run -p 8080:8080 --rm ktor-cv-image`

