package pl.pwr.adam.zmuda.catalog.data

import pl.pwr.adam.zmuda.catalog.R

object FakeDatabase {
    private val CATEGORY_ELECTRIC = Category("Lokomotywy elektryczne", R.drawable.category_electric)
    private val CATEGORY_DIESEL = Category("Lokomotywy spalinowe", R.drawable.category_diesel)
    private val CATEGORY_EZT = Category("Elektryczne zespoły trakcyjne", R.drawable.category_ezt)
    private val CATEGORY_SZT = Category("Spalinowe zespoły trakcyjne", R.drawable.category_szt)

    val CATEGORIES = listOf(
        CATEGORY_ELECTRIC,
        CATEGORY_DIESEL,
        CATEGORY_EZT,
        CATEGORY_SZT
    )

    private val GALLERY_PICTURES = listOf(
        R.drawable.gallery_picture_1,
        R.drawable.gallery_picture_2,
        R.drawable.gallery_picture_3,
        R.drawable.gallery_picture_4,
        R.drawable.gallery_picture_5,
        R.drawable.gallery_picture_6,
        R.drawable.gallery_picture_7,
        R.drawable.gallery_picture_8,
        R.drawable.gallery_picture_9,
        R.drawable.gallery_picture_10,
        R.drawable.gallery_picture_11,
        R.drawable.gallery_picture_12,
        R.drawable.gallery_picture_13,
        R.drawable.gallery_picture_14,
        R.drawable.gallery_picture_15,
        R.drawable.gallery_picture_16
    )

    private val ET41_NUMBERS = listOf(
        TrainNumber("ET41-001", "91 51 3 160 327-5 (PL-PKPC A)", "PKP Cargo S.A."),
        TrainNumber("ET41-002", "91 51 3 160 329-1 (PL-PKPC A)", "PKP Cargo S.A."),
        TrainNumber("ET41-004", "91 51 3 160 331-7 (PL-PKPC A)", "PKP Cargo S.A.")
    )

    private val ET42_NUMBERS = listOf(
        TrainNumber("ET41-001", "91 51 3 160 021-4 (PL-PKPC A)", "PKP Cargo S.A."),
        TrainNumber("ET41-002", "91 51 3 160 023-0 (PL-PKPC A)", "PKP Cargo S.A."),
        TrainNumber("ET41-004", "91 51 3 160 025-5 (PL-PKPC A)", "PKP Cargo S.A.")
    )

    private val EU07_NUMBERS = listOf(
        TrainNumber("EU07-005", "91 51 5 140 176-0 (PL-PKPIC)", "PKP Intercity S.A."),
        TrainNumber("EU07-009", "91 51 5 140 254-1 (PL-ID)", "AlzaCargo"),
        TrainNumber("EU07-012", "91 51 5 140 177-4 (PL-KLP)", "PUK Kolprem Sp. z.o.o.")
    )

    private val ET25_NUMBERS = listOf(
        TrainNumber("ET25-001", "91 51 3 160 427-3 (PL-PKPC)", "PKP Cargo S.A."),
        TrainNumber("ET25-002", "91 51 3 160 428-1 (PL-PKPC)", "PKP Cargo S.A."),
        TrainNumber("ET25-003", "91 51 3 160 429-9 (PL-PKPC)", "PKP Cargo S.A.")
    )

    private val SU45_NUMBERS = listOf(
        TrainNumber("SU45-079", "92 51 5 630 064-0 (PL-PREG)", "ALS S.C. Stary Sącz"),
        TrainNumber("SU45-089", "92 51 5 630 065-7 (PL-PREG)", "ALS S.C. Stary Sącz")
    )

    private val ST44_NUMBERS = listOf(
        TrainNumber("ST44-1201", "92 51 3 630 065-2 (PL-PKPC)", "PKP Cargo S.A."),
        TrainNumber("ST44-1202", "92 51 3 630 066-0 (PL-PKPC)", "PKP Cargo S.A."),
        TrainNumber("ST44-1203", "92 51 3 630 067-8 (PL-PKPC)", "PKP Cargo S.A.")
    )

    private val SM42_NUMBERS = listOf(
        TrainNumber("SM42-003", "98 51 8 621 005-2 (PL-MTPL)", "METRANS Polonia"),
        TrainNumber("SM42-028", "98 51 8 620 261-2 (PL-PKPC)", "PKP Cargo S.A."),
        TrainNumber("SM42-033", "98 51 8 620 775-1 (PL-PKPIC)", "PKP Intercity S.A.")
    )

    private val _31WE_NUMBERS = listOf(
        TrainNumber("31WE-001", "94 51 2 140 287-5 (PL-KD A)", "Koleje Dolnośląskie S.A."),
        TrainNumber("31WE-002", "94 51 2 140 291-7 (PL-KD A)", "Koleje Dolnośląskie S.A."),
        TrainNumber("31WE-003", "94 51 2 140 295-8 (PL-KD A)", "Koleje Dolnośląskie S.A.")
    )

    private val EN57_NUMBERS = listOf(
        TrainNumber("EN57-001", "94 51 2 120 858-7 (PL-PREG ra)", "PolRegio Sp. z o.o."),
        TrainNumber("EN57-038", "94 51 2 120 724-1 (PL-KMKOL ra)", "Koleje Mazowieckie - KM Sp. z o.o.")
    )

    private val ED161_NUMBERS = listOf(
        TrainNumber("ED161-001", "94 51 2 150 213-8 (PL-PKPIC A)", "PKP Intercity S.A."),
        TrainNumber("ED161-002", "94 51 2 150 221-1 (PL-PKPIC A)", "PKP Intercity S.A."),
        TrainNumber("ED161-003", "94 51 2 150 229-4 (PL-PKPIC A)", "PKP Intercity S.A.")
    )

    private val SA140_NUMBERS = listOf(
        TrainNumber("SA140-001", "95 51 2 820 140-2 (PL-PREG A)", "PolRegio Sp. z o.o."),
        TrainNumber("SA140-002", "95 51 2 820 142-8 (PL-PREG A)", "PolRegio Sp. z o.o."),
        TrainNumber("SA140-003", "95 51 2 820 144-4 (PL PREG A)", "PolRegio Sp. z o.o.")
    )

    private val SA105_NUMBERS = listOf(
        TrainNumber("SA105-001", "95 51 2 710 001-9 (PL-PLKW)", "Koleje Wielkopolskie sp. z o.o."),
        TrainNumber("SA105-002", "95 51 2 710 002-7 (PL-PREG)", "Koleje Wielkopolskie sp. z o.o."),
        TrainNumber("SA105-101", "95 51 2 710 012-6 (PL-PREG)", "PolRegio Sp. z o.o.")
    )

    val TRAINS = listOf(
        Train("ET41", R.drawable.picture_et41, CATEGORY_ELECTRIC, R.string.et41_description, GALLERY_PICTURES.shuffled(), ET41_NUMBERS),
        Train("ET42", R.drawable.picture_et42, CATEGORY_ELECTRIC, R.string.et42_description, GALLERY_PICTURES.shuffled(), ET42_NUMBERS),
        Train("EU07", R.drawable.picture_eu07, CATEGORY_ELECTRIC, R.string.eu07_description, GALLERY_PICTURES.shuffled(), EU07_NUMBERS),
        Train("ET25", R.drawable.picture_et25, CATEGORY_ELECTRIC, R.string.et25_description, GALLERY_PICTURES.shuffled(), ET25_NUMBERS),
        Train("SU45", R.drawable.picture_su45, CATEGORY_DIESEL, R.string.su45_description, GALLERY_PICTURES.shuffled(), SU45_NUMBERS),
        Train("ST44", R.drawable.picture_st44, CATEGORY_DIESEL, R.string.st44_description, GALLERY_PICTURES.shuffled(), ST44_NUMBERS),
        Train("SM42", R.drawable.picture_sm42, CATEGORY_DIESEL, R.string.sm42_description, GALLERY_PICTURES.shuffled(), SM42_NUMBERS),
        Train("31WE", R.drawable.picture_31we, CATEGORY_EZT, R.string._31we_description, GALLERY_PICTURES.shuffled(), _31WE_NUMBERS),
        Train("EN57", R.drawable.picture_en57, CATEGORY_EZT, R.string.en57_description, GALLERY_PICTURES.shuffled(), EN57_NUMBERS),
        Train("ED161", R.drawable.picture_ed161, CATEGORY_EZT, R.string.ed161_description, GALLERY_PICTURES.shuffled(), ED161_NUMBERS),
        Train("SA140", R.drawable.picture_sa140, CATEGORY_SZT, R.string.sa140_description, GALLERY_PICTURES.shuffled(), SA140_NUMBERS),
        Train("SA105", R.drawable.picture_sa105, CATEGORY_SZT, R.string.sa105_description, GALLERY_PICTURES.shuffled(), SA105_NUMBERS)
    )
}