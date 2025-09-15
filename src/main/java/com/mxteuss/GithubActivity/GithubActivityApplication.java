package com.mxteuss.GithubActivity;

import com.mxteuss.GithubActivity.controller.GitHubController;

import java.io.IOException;

public class GithubActivityApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		GitHubController gitHubController = new GitHubController("mxteuss");
	}

}
