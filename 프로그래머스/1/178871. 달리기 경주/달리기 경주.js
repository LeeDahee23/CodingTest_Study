function solution(players, callings) {
    const ranking = new Map();
    players.forEach((player, index) => ranking.set(player, index));
    
    callings.forEach(calling => {
        const rank = ranking.get(calling);
        const prePlayer = players[rank-1];
        const postPlayer = calling;
        
        players[rank-1] = postPlayer;
        players[rank] = prePlayer;
        ranking.set(prePlayer, rank);
        ranking.set(postPlayer, rank-1);
    })
    
    return players;
}