# Mock File Transfer Design Patterns
This repository contains a Kotlin implementation of design patterns for mock file transfer from one cloud service to another (Azure to AWS or AWS to Azure). It includes the following design patterns:

* Factory Method
* Strategy
* Decorator
* Template Method
* Abstract Factory
## Factory Method Pattern
The Factory Method pattern is used to create CloudStorage objects for either AWS or Azure. The abstract CloudStorageFactory class defines a createCloudStorage method that is implemented by the AwsCloudStorageFactory and AzureCloudStorageFactory classes. The CloudStorage interface defines the methods for uploading and downloading files to and from the cloud service.

## Strategy Pattern
The Strategy pattern is used to create RSA or AES decryptors for files flow. The abstract DecryptorStrategy class defines a decrypt method that is implemented by the RsaDecryptor and AesDecryptor classes. These classes decrypt files using RSA or AES encryption algorithms.

## Decorator Pattern
The Decorator pattern is used to add decryption functionality to the CloudStorage interface using the CloudStorageDecorator class. This class takes a CloudStorage object as a parameter and adds decryption functionality to its methods.

## Template Method Pattern
The Template Method pattern is used to create messages flow. The abstract MessageTemplate class defines a sendMessage method that is implemented by the AwsMessage and AzureMessage classes. These classes send messages to either AWS or Azure.

## Abstract Factory Pattern
The Abstract Factory pattern is used to create either a storage or message client. The abstract ClientFactory class defines a createStorage method that is implemented by the AwsClientFactory and AzureClientFactory classes. It also defines a createMessage method that is implemented by the AwsClientFactory and AzureClientFactory classes. These classes create either an AWS or Azure storage client and message client.

## Usage
To use this implementation, simply create a ClientFactory object and call its createStorage method to create a CloudStorage object for either AWS or Azure. Then call its createMessage method to create a message client for either AWS or Azure.

```kotlin

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
```

## Conclusion
This Kotlin implementation of design patterns for mock file transfer from one cloud service to another provides a flexible and extensible solution for cloud storage and messaging needs. The combination of the Factory Method, Strategy, Decorator, Template Method, and Abstract Factory patterns allows for easy customization and scalability.
