// ContactListItem.kt
package com.RehanTariq.i220965

sealed class ContactListItem {
    data class SectionHeader(val title: String) : ContactListItem()
    data class Contact(
        val name: String,
        val avatarRes: Int,      // or a URL if loading images from the internet
        val inContacts: Boolean  // true -> show chat icon, false -> show Invite button
    ) : ContactListItem()
}
