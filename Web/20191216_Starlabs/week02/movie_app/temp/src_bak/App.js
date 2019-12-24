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
        this._getMovies()
    }

    // 렌더링 실행함수
    _renderMovies = () => {
        const movies = this.state.movies.map(movie => {
            console.log(movies)
            return <Movie
                title={movie.title_english}
                poster={movie.small_cover_image}
                key={movie.id}
                genres={movie.genres}
                synopsis={movie.synopsis}
            />
        })
        return movies
    }

    _getMovies = async () => {
        const movies = await this._callApi()
        this.setState({
            movies
        })
    }

    // api 호출
    _callApi = () => {
        fetch('https://yts.lt/api/v2/list_movies.json?sort_by=rating')
        .then(response => response.json())
        .then(json => json.data.movies)
        .catch(err => console.log(err))
    }


    render() {
        const { movies } = this.state;
        return (
            <div className={movies ? "App" : "App--loading"}>
            {movies ? this._renderMovies() : 'Loading'}
            </div>
        );
    }
}

export default App;
