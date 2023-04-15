package decryption

class RsaDecryptor: IDecryptor {
    override fun decrypt(fileContent: String): String {
        println("rsa decrypting")
        return fileContent.filterIndexed { index, c -> index%2 == 0 }
    }
}