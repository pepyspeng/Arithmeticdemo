package j.com.lib

class test {

    /**
     * Reads the headers of the provided [hprofFile] and returns an opened [Hprof]. Don't forget
     * to call [close] once done.
     */
    fun open(hprofFile: File): Hprof {
        val fileLength = hprofFile.length()
        if (fileLength == 0L) {
            throw IllegalArgumentException("Hprof file is 0 byte length")
        }
        val inputStream = hprofFile.inputStream()
        val channel = inputStream.channel
        val source = Okio.buffer(Okio.source(inputStream))
        val endOfVersionString = source.indexOf(0)
        val versionName = source.readUtf8(endOfVersionString)
        val hprofVersion = supportedVersions[versionName]
        require(hprofVersion != null) {
            "Unsupported Hprof version [$versionName] not in supported list ${supportedVersions.keys}"
        }
        // Skip the 0 at the end of the version string.
        source.skip(1)
        val identifierByteSize = source.readInt()
        // heap dump timestamp
        val heapDumpTimestamp = source.readLong()
        val byteReadCount = endOfVersionString + 1 + 4 + 8
        val reader = HprofReader(source, identifierByteSize, byteReadCount)
        return Hprof(
            channel, source, reader, heapDumpTimestamp, hprofVersion, fileLength
        )
    }
}