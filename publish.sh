# Build the Docker image with sbt
sbt Docker/publishLocal

# Tag the image for Docker Hub
docker tag fresk-backend paultisaw/fresk-dev:latest

# Log in to Docker Hub
docker login

# Push the image to Docker Hub
docker push paultisaw/fresk-dev:latest
