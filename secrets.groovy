import jenkins.model.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import org.jenkinsci.plugins.plaincredentials.*
import org.jenkinsci.plugins.plaincredentials.impl.*
import hudson.util.Secret


domain = Domain.global()
store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()

rancher_access_key = new StringCredentialsImpl(
CredentialsScope.GLOBAL,
"rancher_access_key",
"rancher_access_key",
Secret.fromString(System.getenv("rancher_access_key")))

rancher_access_secret = new StringCredentialsImpl(
CredentialsScope.GLOBAL,
"rancher_access_secret",
"rancher_access_secret",
Secret.fromString(System.getenv("rancher_access_secret")))

TF_VAR_RABBITMQ_PASSWORD = new StringCredentialsImpl(
CredentialsScope.GLOBAL,
"TF_VAR_RABBITMQ_PASSWORD",
"TF_VAR_RABBITMQ_PASSWORD",
Secret.fromString(System.getenv("TF_VAR_RABBITMQ_PASSWORD")))

TF_VAR_SA_PASSWORD = new StringCredentialsImpl(
CredentialsScope.GLOBAL,
"TF_VAR_SA_PASSWORD",
"TF_VAR_SA_PASSWORD",
Secret.fromString(System.getenv("TF_VAR_SA_PASSWORD")))

ARTIFACTORY_PASSWORD = new StringCredentialsImpl(
CredentialsScope.GLOBAL,
"ARTIFACTORY_PASSWORD",
"ARTIFACTORY_PASSWORD",
Secret.fromString(System.getenv("ARTIFACTORY_PASSWORD")))

artifactory_docker_password = new StringCredentialsImpl(
CredentialsScope.GLOBAL,
"artifactory_docker_password",
"artifactory_docker_password",
Secret.fromString(System.getenv("artifactory_docker_password")))

store.addCredentials(domain, artifactory_docker_password)
store.addCredentials(domain, ARTIFACTORY_PASSWORD)
store.addCredentials(domain, TF_VAR_SA_PASSWORD)
store.addCredentials(domain, TF_VAR_RABBITMQ_PASSWORD)
store.addCredentials(domain, rancher_access_key)
store.addCredentials(domain, rancher_access_secret)
