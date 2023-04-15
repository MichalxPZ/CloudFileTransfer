import clientFactories.AwsCloudClientFactory
import clientFactories.AzureCloudClientFactory
import clientFactories.ICloudClientFactory
import dataFlows.StorageToStorageDataFlow
import decryption.AesDecryptorFactory
import decryption.DecryptorType
import decryption.IDecryptorFactory
import decryption.RsaDecryptorFactory
import storage.IStorageClient

fun main(args: Array<String>) {
    val decryptorType = DecryptorType.RSA
    val decryptorFactory: IDecryptorFactory? = when (decryptorType) {
        DecryptorType.RSA -> RsaDecryptorFactory()
        DecryptorType.AES -> AesDecryptorFactory()
        DecryptorType.NONE -> null
    }

    val decryptor = decryptorFactory?.createDecryptor(decryptorType)
    val azureClientFactory: ICloudClientFactory = createCloudClientFactory(
        cloudClient = CloudServiceProviderType.Azure)
    val azureStorageClient = azureClientFactory.createStorageClient()
    val azureMessageClient = azureClientFactory.createMessageClient()

    val awsClientFactory: ICloudClientFactory = createCloudClientFactory(
        cloudClient = CloudServiceProviderType.Aws)
    val awsStorageClient: IStorageClient = if (decryptor != null) {
        awsClientFactory.createStorageClient(decryptor)
    } else {
        awsClientFactory.createStorageClient()
    }
    val awsMessageClient = awsClientFactory.createMessageClient()

    val dataFlow = StorageToStorageDataFlow(awsStorageClient, azureStorageClient)
    dataFlow.execute()
}

fun createCloudClientFactory(cloudClient: CloudServiceProviderType): ICloudClientFactory {
    val cloudClientFactory: ICloudClientFactory = when(cloudClient) {
        CloudServiceProviderType.Azure -> AzureCloudClientFactory()
        CloudServiceProviderType.Aws -> AwsCloudClientFactory()
    }
    return cloudClientFactory

}

enum class CloudServiceProviderType {
    Azure, Aws
}