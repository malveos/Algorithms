import React, { Component, Suspense } from 'react';
import { Route, NavLink, withRouter, Switch, Redirect } from 'react-router-dom';

//import Posts from '../Posts/Posts';
//import NewPosts from '../NewPost/NewPost';
import AsyncComponent from '../../../hoc/asyncComponent';
import classes from './Blog.css';

const Posts = React.lazy(() => import('../Posts/Posts'));

const AsyncNewPost = AsyncComponent(() => {
    return import('../NewPost/NewPost');
});

class Blog extends Component {
    render() {
        return (
            <div className={classes.Blog}>
                <header>
                    <nav>
                        <ul>
                            <li><NavLink
                                activeClassName={classes.active}
                                to={this.props.match.url + "/posts"}
                                exact
                            >Posts</NavLink></li>
                            <li><NavLink
                                activeClassName={classes.active}
                                to={{
                                    pathname: this.props.match.url + '/new-post',
                                    hash: '#submit',
                                    search: '?sub=true'
                                }}>New Post</NavLink></li>
                        </ul>
                    </nav>
                </header>
                {/* <Route path="/new-post" exact render/> */}
                <Switch>
                    <Route path={this.props.match.url + "/new-post"} component={AsyncNewPost} />
                    <Route
                        path={this.props.match.url + "/posts"}
                        render={() => (
                            <Suspense fallback={<h2>Loading....</h2>}>
                                <Posts />
                            </Suspense>)} />
                    <Redirect from={this.props.match.url + "/"} to={this.props.match.url + "/posts"} />
                    <Route render={() => <h1>Page not found!...</h1>} />
                </Switch>
            </div>
        );
    }
}

export default withRouter(Blog);