import React from 'react'
import './CharComponent.css'

const CharComponent = (props) => {
return <div className='CComp' onClick={props.clicked}>{props.char}</div>
}

export default CharComponent