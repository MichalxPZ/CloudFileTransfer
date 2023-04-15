package decryption

interface IDecryptorFactory {
    fun createDecryptor(decryptorType: DecryptorType): IDecryptor
}

enum class DecryptorType{
    RSA, AES, NONE
}