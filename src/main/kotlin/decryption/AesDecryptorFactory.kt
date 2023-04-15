package decryption

class AesDecryptorFactory: IDecryptorFactory {
    override fun createDecryptor(decryptorType: DecryptorType): IDecryptor {
        return AesDecryptor()
    }
}