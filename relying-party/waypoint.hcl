project = "relying-party"

runner {
  enabled = true
  profile = "psc-pocs"
  data_source "git" {
    url = "https://github.com/ClaireJuil/P2"
    ref = "main"
	path = "relying-party/"
	ignore_changes_outside_path = true
  }
  poll {
    enabled = false
  }
}

app "rp" {
  build {

    use "docker" {
      dockerfile = "${path.app}/Dockerfile"
    }

    registry {
      use "docker" {
        image = "${var.registry_username}/relying-party"
        tag = gitrefpretty()
        username = var.registry_username
        password = var.registry_password
        local = true
      }
    }
  }

  deploy {
    use "nomad-jobspec" {
      jobspec = templatefile("${path.app}/relyingparty.nomad.tpl", {
        datacenter = var.datacenter
        log_level = debug
      })
    }
  }
}

variable "datacenter" {
  type    = string
  default = "pocs-ans-psc"
  env     = ["NOMAD_DATACENTER"]
}

variable "registry_username" {
  type      = string
  default   = ""
  env       = ["REGISTRY_USERNAME"]
  sensitive = true
}

variable "registry_password" {
  type      = string
  default   = ""
  env       = ["REGISTRY_PASSWORD"]
  sensitive = true
}

variable "log_level" {
  type    = string
  default = "INFO"
}


