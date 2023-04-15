package decryption

class AesDecryptor: IDecryptor {
    override fun decrypt(fileContent: String): String {
        println("aes decrypting")
        return fileContent.reversed()
    }
}