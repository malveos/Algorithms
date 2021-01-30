import React, { Component } from 'react'
//import Radium from 'radium'
//import styled from 'styled-components'
import PropTypes from 'prop-types'
import classes from './Person.css'
import AuxFile from '../../../hoc/AuxiFile'
import WithClass from '../../../hoc/WithClass'
import AuthContext from '../../../context/authContext'

class Person extends Component {

    constructor(props) {
        super(props);
        this.inputElem = React.createRef();
    }

    componentDidMount() {
        //document.querySelector('input').focus();
        //this.inputElem.focus();
        this.inputElem.current.focus();
    }

    static contextType = AuthContext;

    render() {
        return (<AuxFile>
            {/* <AuthContext.Consumer>
                {
                    context => context.authenticated ? <p>Authentication successful</p> : <p>Please Login</p>
                }
            </AuthContext.Consumer> */}
            {this.context.authenticated ? <p>Authentication successful</p> : <p>Please Login</p>}

            <p onClick={this.props.click}>I am a {this.props.name} and {this.props.age} years old</p>
            <p>{this.props.children}</p>
            <input type="text"
                //ref={(ele)=> this.inputElem = ele}
                ref={this.inputElem}
                onChange={this.props.change}
                value={this.props.name}></input>
        </AuxFile>);
    }
}

Person.propTypes = {
    click: PropTypes.func,
    name: PropTypes.string,
    age: PropTypes.number,
    change: PropTypes.func
};

//export default Radium(person);
export default WithClass(Person, classes.Person);