import React from 'react'

const userOutput = (props) => {
    return <div >
            <p> My username is {props.username}</p>
            <p  onClick={props.changepara}>I love the way react works. </p>
        </div>
};

export default userOutput