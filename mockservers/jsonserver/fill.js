module.exports = function() {
    var faker = require('faker');
    var _ = require('lodash');
    return {
        monkey: _.times(10, function(n) {
            return {
                id: n,
                name: faker.name.findName(),
                image: faker.image.animals()
            }
        })
    }
}