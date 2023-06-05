
resource "google_container_cluster" "my_cluster" {
  name               = "my-gke-cluster"
  location           = "europe-west2"

  initial_node_count = 1

  node_config {
    machine_type = "e2-standard-2"

    metadata = {
      disable-legacy-endpoints = "true"
    }

    oauth_scopes = [
      "https://www.googleapis.com/auth/logging.write",
      "https://www.googleapis.com/auth/monitoring",
    ]
  }
}
