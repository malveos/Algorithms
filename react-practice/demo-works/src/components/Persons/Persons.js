import React, { Component } from 'react';
import Person from './Person/Person';

class Persons extends Component {

    // PureComponent already implement below function with all props check.
    // shouldComponentUpdate(nextProps, nextstate) {
    //     console.log('[Persons.js] shouldComponentUpdate called.');
    //     //console.log(nextProps);
    //     //return nextProps.persons !== this.props.persons;
    //     return true;
    // }

    render() {
        console.log('[Persons.js] Persons called.');
        return (this.props.persons.map((p, index) => {
            return <Person
                name={p.name}
                age={p.age}
                key={p.id}
                change={(event) => this.props.changed(event, index)}
                click={() => this.props.clicked(index)}
            />
        }
        ));
    }

};


export default Persons;