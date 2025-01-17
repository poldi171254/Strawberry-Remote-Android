package au.llist.strawberryremoteandroid.util

import kotlin.properties.Delegates

data class SongInfo(var intitle: String) {
    lateinit var title: String
    lateinit var album: String
    lateinit var artist: String
    lateinit var albumartist: String
    var track by Delegates.notNull<Int>()
    lateinit var strYear: String
    lateinit var genre: String
    var playcount by Delegates.notNull<Int>()
    lateinit var songlength: String
}