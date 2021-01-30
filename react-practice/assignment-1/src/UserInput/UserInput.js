import React from 'react'
import './UserInput.css'


const userInput = (props) => {
    return <div className="Input"><input onChange={props.changeName}></input></div>
};

export default userInput