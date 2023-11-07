# CArtAgO Docker repository

The repository stores all versions of the "CArtAgO" Docker image.

[![Build status](https://github.com/cake-lier/cartago-docker/actions/workflows/release.yml/badge.svg)](https://github.com/cake-lier/cartago-docker/actions/workflows/release.yml)
[![semantic-release: conventional-commits](https://img.shields.io/badge/semantic--release-conventional_commits-e10098?logo=semantic-release)](https://github.com/semantic-release/semantic-release)
[![Latest release](https://img.shields.io/github/v/release/cake-lier/cartago-docker)](https://github.com/cake-lier/cartago-docker/releases/latest/)
[![Javadoc](https://img.shields.io/github/v/release/cake-lier/cartago-docker?label=javadoc)](https://cake-lier.github.io/cartago-docker/io/github/cake-lier)
[![Issues](https://img.shields.io/github/issues/cake-lier/cartago-docker)](https://github.com/cake-lier/cartago-docker/issues)
[![Pull requests](https://img.shields.io/github/issues-pr/cake-lier/cartago-docker)](https://github.com/cake-lier/cartago-docker/pulls)
[![Codecov](https://codecov.io/gh/cake-lier/cartago-docker/branch/main/graph/badge.svg?token=UX36N6CU78)](https://codecov.io/gh/cake-lier/cartago-docker)

## What is this?

The project in this repository is used for wrapping a CArtAgO infrastructure node into a Docker container.
In this way, a new CArtAgO node deployment is greatly simplified, having to download an image from DockerHub.
It will run as any other process on your machine,
so it can be exposed to other nodes to allow agents from remote workspaces on those nodes to join it.

## Are there any configurations?

Yes, you can configure the name of the environment you are launching,
the name of the root workspace, and the port you are exposing the service on.
By default, these three parameters are, respectively, the "mas" string, the "/main" string, and the integer 20100.
These can be overridden when launching the docker container specifying the environment variables "ENV_NAME,"
"ROOT_NAME" and "PORT," respectively.
If you decide to launch directly the JAR deployed by this repository,
it would be best if you used the following arguments to update those parameters.

| Short option | Long option | What is going to update                  |
|--------------|-------------|------------------------------------------|
| -e           | --env-name  | The environment name                     |
| -r           | --root-name | The root workspace name                  |
| -p           | --port      | The port on which the service is exposed |

## How to run the Docker image?

The Docker image is published on DockerHub,
so you need to declare its name in your Dockerfile or "docker-compose" file to use it and nothing more.
To use the latest version,
use the tag `matteocastellucci3/cartago:latest`, or,
if you prefer a specific version, substitute `latest` with the one you like.
Then, wait until the message `[ CArtAgO Web Service Layer ] Ready.` appears on the screen to see it ready.

## I won't use Docker, is there another way?

The JAR file run inside the Docker container is published in the releases of this repository.
You need to find the appropriate version you need and then download it.
Then, it's as simple as running `java -jar main.jar` in a terminal to see it at work.
Then, wait until the message `[ CArtAgO Web Service Layer ] Ready.` appears on the screen to see it ready.