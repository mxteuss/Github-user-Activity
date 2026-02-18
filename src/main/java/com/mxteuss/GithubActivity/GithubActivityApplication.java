package com.mxteuss.GithubActivity;

import com.mxteuss.GithubActivity.controller.GitHubController;

import java.io.IOException;
import java.util.Scanner;

public class GithubActivityApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Type the username: ");
		String username = sc.nextLine();
		new GitHubController(username);
	}

}
