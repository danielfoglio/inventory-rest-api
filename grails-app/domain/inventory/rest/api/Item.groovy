package inventory.rest.api

class Item {
    String name

    static hasMany = [loctions: Location]

    static constraints = {
    }
}
