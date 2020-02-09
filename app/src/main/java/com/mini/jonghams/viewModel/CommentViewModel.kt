package com.mini.jonghams.viewModel

import androidx.lifecycle.ViewModel
import com.mini.jonghams.model.User

class CommentViewModel : ViewModel() {
    var commentList: MutableList<User> = ArrayList()

    init {
        commentList.add(
            User(
                "Kim Penh",
                "https://scontent.fpnh2-1.fna.fbcdn.net/v/t1.0-1/81985482_1510304765786004_995523580412297216_o.jpg?_nc_cat=110&_nc_eui2=AeH5gpgv3EJCkAaoU4rGiT6pPbvsvuqjLnhY9IL2yObbGroyXvvREd9soGqlyK-d0CcCPT8HocDnrjXDrwhspVnGOMA2Gj9lkqub6gjF0GuchA&_nc_oc=AQnnKV2nNIN5hsCgtkrVsdIjY-qr52mL_c0OeH62HIv9AZb_X65sNhUi70AHIWtFwUY&_nc_ht=scontent.fpnh2-1.fna&oh=0ccb25dbe6f1d00d6ddb44e13aa12e41&oe=5ED8F9E5",
                "Very good coffee, great tastes of sandwich, But it seems like recently I've never been able to find a seat event I'm waiting for long time",
                4,
                10
            )
        )


        commentList.add(
            User(
                "Norng Samath",
                "https://scontent.fpnh2-2.fna.fbcdn.net/v/t1.0-9/66260717_2502660953090065_2770750782096539648_o.jpg?_nc_cat=106&_nc_eui2=AeG3LkiJVCd8xUfRWjCnU560ie9BWCkmU1R2knwc9WnC5x0-CaFJYFVnDj8sOjRgfE8jqP5R8NohbA1tWWzaaPkfRLhiFWV3wrh2X2NyDG429g&_nc_oc=AQnLvrnpVIqX_RYMa54RCjQrEy65HQHjopfiiCkLUNq5zLiCSYRr0qDMLisgYR9l2q0&_nc_ht=scontent.fpnh2-2.fna&oh=82e0f68b56f9c20483b4ca0bbd3b1539&oe=5ECF7DA0",
                "I like tastes of your coffee. I always go to drink milk coffee with my friend during weekend. sometime I work full day at there",
                5,
                50
            )
        )

        commentList.add(
            User(
                "Pal Ravy",
                "https://scontent.fpnh2-2.fna.fbcdn.net/v/t1.0-9/70398357_1743874442422871_7928406781129129984_o.jpg?_nc_cat=108&_nc_eui2=AeHDSEnOGabySCqMovNhbugg8hweSzSp7tclmZmlWH2IsNBvc42q0s90Vg0FhS5TjHaXahFEgUZl5zfgHcEcz58Ye0_juw1Z_EqC4_OxLiWdOQ&_nc_oc=AQk9BITxEpK6Y0oiIRiHIXEtAb_6jUpvePVWGgptIXrccpYnu0pq2MCQ-EVEOHRq6A0&_nc_ht=scontent.fpnh2-2.fna&oh=d9c1844eb6d31b6e13315902c0249e14&oe=5ECB3606",
                "This app look so good and easy to use.This app look so good and easy to use",
                3,
                20
            )
        )
    }
}
