<h2><a href="https://leetcode.com/problems/last-stone-weight/">1046. Last Stone Weight</a></h2><h3>Easy</h3><hr><div><p>You are given an array of integers <code>stones</code> where <code>stones[i]</code> is the <gistnote class="gistnote-highlight" highlightid="f8502a0d-d076-4db3-ad61-34ef4656877a" colornum="1" style="background-color: rgb(255, 202, 215);" id="f8502a0d-d076-4db3-ad61-34ef4656877a">weight of the </gistnote><code><gistnote class="gistnote-highlight" highlightid="f8502a0d-d076-4db3-ad61-34ef4656877a" colornum="1" style="background-color: rgb(255, 202, 215);">i</gistnote><sup><gistnote class="gistnote-highlight" highlightid="f8502a0d-d076-4db3-ad61-34ef4656877a" colornum="1" style="background-color: rgb(255, 202, 215);">th</gistnote></sup></code><gistnote class="gistnote-highlight" highlightid="f8502a0d-d076-4db3-ad61-34ef4656877a" colornum="1" style="background-color: rgb(255, 202, 215);"> stone</gistnote>.</p>

<p>We are playing a game with the stones. On each turn, we choose the <strong>heaviest two stones</strong> and smash them together. Suppose the heaviest two stones have weights <code>x</code> and <code>y</code> with <code>x &lt;= y</code>. The result of this smash is:</p>

<ul>
	<li>If <code>x == y</code>, <gistnote class="gistnote-highlight" highlightid="d233b3ac-c7c8-41b9-9eb9-eb948f1e8bb1" colornum="1" style="background-color: rgb(255, 202, 215);" id="d233b3ac-c7c8-41b9-9eb9-eb948f1e8bb1">both stones are destroyed</gistnote>, and</li>
	<li>If <code>x != y</code>, the <gistnote class="gistnote-highlight" highlightid="dd862beb-65e9-4949-8227-c21f5ded9cfc" colornum="1" style="background-color: rgb(255, 202, 215);" id="dd862beb-65e9-4949-8227-c21f5ded9cfc">stone of weight </gistnote><code><gistnote class="gistnote-highlight" highlightid="dd862beb-65e9-4949-8227-c21f5ded9cfc" colornum="1" style="background-color: rgb(255, 202, 215);">x</gistnote></code><gistnote class="gistnote-highlight" highlightid="dd862beb-65e9-4949-8227-c21f5ded9cfc" colornum="1" style="background-color: rgb(255, 202, 215);"> is destroyed</gistnote>, and the stone of weight <code><gistnote class="gistnote-highlight" highlightid="f5d3adff-e0d5-4e7a-bfd3-5049e999b477" colornum="1" style="background-color: rgb(255, 202, 215);" id="f5d3adff-e0d5-4e7a-bfd3-5049e999b477">y</gistnote></code><gistnote class="gistnote-highlight" highlightid="f5d3adff-e0d5-4e7a-bfd3-5049e999b477" colornum="1" style="background-color: rgb(255, 202, 215);"> has new weight </gistnote><code><gistnote class="gistnote-highlight" highlightid="f5d3adff-e0d5-4e7a-bfd3-5049e999b477" colornum="1" style="background-color: rgb(255, 202, 215);">y - x</gistnote></code><gistnote class="gistnote-highlight" highlightid="f5d3adff-e0d5-4e7a-bfd3-5049e999b477" colornum="1" style="background-color: rgb(255, 202, 215);">.</gistnote></li>
</ul>

<p>At the end of the game, there is <strong>at most one</strong> stone left.</p>

<p>Return <em>the smallest possible weight of the left stone</em>. If there are no stones left, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> stones = [2,7,4,1,8,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> stones = [1]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= stones.length &lt;= 30</code></li>
	<li><code>1 &lt;= stones[i] &lt;= 1000</code></li>
</ul>
</div>