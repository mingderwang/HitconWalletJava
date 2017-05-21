package org.walleth.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.item_address_book.view.*
import org.ligi.kaxt.setVisibility
import org.walleth.data.addressbook.AddressBookEntry
import org.walleth.data.keystore.WallethKeyStore

class AddressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(addressBookEntry: AddressBookEntry,keyStore: WallethKeyStore, onClickAction: (entry: AddressBookEntry) -> Unit) {

        itemView.setOnClickListener {
            onClickAction.invoke(addressBookEntry)
        }

        itemView.address_name.text = addressBookEntry.name

        itemView.key_indicator.setVisibility(keyStore.hasKeyForForAddress(addressBookEntry.address))
        if (addressBookEntry.note == null || addressBookEntry.note!!.isBlank()) {
            itemView.address_note.visibility = GONE
        } else {
            itemView.address_note.visibility = VISIBLE
            itemView.address_note.text = addressBookEntry.note
        }

        itemView.address_hash.text = addressBookEntry.address.hex
    }

}