package pl.pwr.adam.zmuda.catalog.data

class Train (var name: String, val picture: Int, val category: Category, val description: Int, val galleryPictures: List<Int>, val trainNumbers: List<TrainNumber>) {
    var favourite = false

    constructor(train: Train) : this(train.name, train.picture, train.category, train.description, train.galleryPictures, train.trainNumbers) {
        favourite = train.favourite
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Train

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }


}