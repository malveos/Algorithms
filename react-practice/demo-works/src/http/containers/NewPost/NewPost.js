import React, { Component } from 'react';
import axios from 'axios';

import classes from './NewPost.css';
import { Redirect } from 'react-router-dom';

class NewPost extends Component {
    state = {
        title: '',
        content: '',
        author: 'Max',
        error: false,
        submitted:false
    }

    postDataHandler = () => {
        let postData = {
            title: this.state.title,
            body: this.state.content,
            author: this.state.author
        }
        axios.post('https://jsonplaceholder.typicode.com/posts', postData)
        .then(res => {
            console.log(res);
        }).catch(err=>{
            this.setState({error:true});
            console.log(err);
        });
        this.setState({submitted:true});
    }

    render() {
        let redirect =null;
        if(this.state.submitted) {
            redirect = <Redirect to={'/http-app/posts'} />;
        }
        if(this.state.error){
            return <p style={{textAlign: "center"}}>Something went wrong !!</p>
        }
        return (
            <div className={classes.NewPost}>
                {redirect}
                <h1>Add a Post</h1>
                <label>Title</label>
                <input type="text" value={this.state.title} onChange={(event) => this.setState({ title: event.target.value })} />
                <label>Content</label>
                <textarea rows="4" value={this.state.content} onChange={(event) => this.setState({ content: event.target.value })} />
                <label>Author</label>
                <select value={this.state.author} onChange={(event) => this.setState({ author: event.target.value })}>
                    <option value="Max">Max</option>
                    <option value="Manu">Manu</option>
                </select>
                <button onClick={this.postDataHandler}>Add Post</button>
            </div>
        );
    }
}

export default NewPost;