import React, { Component } from 'react';
import './App.css';
import Movie from './Movie.js';





// 몇 개인지 모르는 리스트 출력

// state는 직접 바꾸면 안된다.

class App extends Component {
    // Render : componentWillMount() -> render() -> componentDidMount()
    // Update componentWillReciveProps() -> shouldComponentUpdate() -> componentWillUpdate() -> render() -> component()
    state = {}

    componentDidMount(){
        fetch('https://yts.lt/api/v2/list_movies.json?sort_by=like_count')
        //.then(response => console.log(response))
        .then(response => response.json())
        .then(json => console.log(json))
        .catch(err => console.log(err))
    }

    // 렌더링 실행함수
    _renderMovies = () => {
        const movies = this.state.movies.map((movie, index) => {
            return <Movie title={movie.title} poster={movie.poster} key={index} />
        })
        return movies
    }

    render() {
        return (
            <div className="App">
                {this.state.movies ? this._renderMovies() : 'Loading'}
            </div>
        );
    }
}

export default App;
