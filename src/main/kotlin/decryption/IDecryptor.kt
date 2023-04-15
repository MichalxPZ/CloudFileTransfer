package decryption

interface IDecryptor {
    fun decrypt(fileContent: String): String
}