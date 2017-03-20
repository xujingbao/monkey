module.exports = function () {
    const faker = require('faker')
    const _ = require('lodash')
    return {
        people: _.times(100, n => {
            return {
                id: n,
                name: faker.name.findName(),
                avatar: faker.internet.avatar(),
            }
        })
    }
}