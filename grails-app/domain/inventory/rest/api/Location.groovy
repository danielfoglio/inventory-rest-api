package inventory.rest.api

class Location {
    String city

    static belongsTo = [item: Item]

    static constraints = { item nullable: true }
}
