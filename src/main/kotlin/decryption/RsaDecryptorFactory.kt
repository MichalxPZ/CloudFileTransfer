package decryption

class RsaDecryptorFactory: IDecryptorFactory {
    override fun createDecryptor(decryptorType: DecryptorType): IDecryptor {
        return RsaDecryptor()
    }
}