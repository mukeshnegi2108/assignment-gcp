# Base image
FROM ubuntu:latest

# Install necessary dependencies
RUN apt-get update && apt-get install -y python3 python3-pip

# Set the working directory
WORKDIR /app

# Specify the command to run when the container starts
CMD ["python3", "app.py"]
