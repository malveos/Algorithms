import React, { Component } from "react";
import axiosInstance from '../../../axios';
import { Route, withRouter } from 'react-router-dom';

import Post from '../../components/Post/Post'
import FullPost from '../FullPost/FullPost'
import classes from './Posts.css'

class Posts extends Component {

    state = {
        posts: [],
        selectedPostID: null,
        error: false
    }

    componentDidMount() {
        axiosInstance.get('/posts')
            .then(response => {
                const posts = response.data.slice(0, 4);
                const updatedPost = posts.map(post => {
                    return {
                        ...post,
                        author: 'Max'
                    }
                });
                this.setState({ posts: updatedPost });
                // console.log(response);
            });
    }

    postSelectHandler = (id) => {
        //this.setState({ selectedPostID: id });
        //this.props.history.push({pathname: '/' + id});
        this.props.history.push(this.props.match.url + '/' +id);
        //console.log('[Posts.js]', this.props.match.url + id);
    }
    render() {
        const posts = this.state.posts.map(post => {
            return (
                // <Link to={'/posts/' + post.id} key={post.id}>
                <Post
                    title={post.title}
                    key={post.id}
                    author={post.author}
                    clicked={() => this.postSelectHandler(post.id)} />
                // </Link>
            );
        });

        return (
            <div>
                <section className={classes.Posts}>
                    {posts}
                </section>
                <Route path={this.props.match.url + '/:id'} exact component={FullPost} />
            </div>
        );
    }
}

export default withRouter(Posts);