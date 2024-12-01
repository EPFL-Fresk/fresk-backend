# Build the Docker image with sbt
sbt Docker/publishLocal

# Tag the image for Docker Hub
docker tag fresk-backend paultisaw/fresk-backend-dev:1.0

# Log in to Docker Hub
docker login

# Push the image to Docker Hub
docker push paultisaw/fresk-backend-dev:1.0
